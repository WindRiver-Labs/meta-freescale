SUMMARY = "Configure TSN funtionalitie"
DESCRIPTION = "A tool to configure TSN funtionalities in user space"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ef58f855337069acd375717db0dbbb6d"

DEPENDS = "cjson libnl readline"

inherit pkgconfig

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI = "git://source.codeaurora.org/external/qoriq/qoriq-components/tsntool;protocol=https;nobranch=1 \
             file://0001-tsntool-optimize-the-condition-of-the-error-output.patch \
             file://0002-libtsn-correct-the-return-value.patch \
             file://0003-fix-parallel-build.patch \
             file://0004-Makefile-use-PKG_CONFIG.patch \
             file://0005-Makefile-add-libtsn.pc.in-file-and-add-install.patch \
             file://0006-genl_tsn.h-use-the-defination-of-bool-in-stdbool.h.patch \
             file://0007-sample-add-pktgen-scripts-for-test.patch \
             file://0008-demos-cnc-add-madatory-node-in-configuration.patch \
             file://0009-demos-cnc-correct-some-prefixes.patch \
             file://0010-demos-cnc-change-operation-mode-from-replace-to-merg.patch \
             file://0011-demo-cnc-limit-Qci-config-index-with-DEC-values.patch \
             file://0012-tsntool-add-tag-v0.4.patch \
             file://0015-tsntool-fix-basetime-get-seconds.decimalseconds-valu.patch \
"

SRCREV = "30a0320eb4a1798ac3d6258a2e02d863e60a1582"
S = "${WORKDIR}/git"

do_configure[depends] += "virtual/kernel:do_shared_workdir"

do_compile_prepend() {
        mkdir -p ${S}/include/linux
        cp -r ${STAGING_KERNEL_DIR}/include/uapi/linux/tsn.h ${S}/include/linux
}     
do_install() {
    install -d ${D}${bindir} ${D}${libdir} 
    install -m 0755 ${S}/tsntool ${D}${bindir}
    install -m 0755 ${S}/tools/event ${D}${bindir}/
    install -m 0755 ${S}/tools/timestamping ${D}${bindir}/
    install -m 0755 ${S}/libtsn.so ${D}${libdir}
}

PACKAGES = "${PN}-dbg ${PN}"
FILES_${PN} = "${libdir}/libtsn.so ${bindir}/*"
INSANE_SKIP_${PN} += "file-rdeps rpaths dev-so"
COMPATIBLE_MACHINE = "(qoriq)"
PARALLEL_MAKE = ""
