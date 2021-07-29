require odp.inc

inherit module

do_compile_prepend () {
    export KERNEL_PATH="${STAGING_KERNEL_DIR}"
    export KERNEL_CFG_PATH="${STAGING_KERNEL_BUILDDIR}"
    cd ${S}/kern
}

do_install () {
    install -d ${D}/lib/modules/${KERNEL_VERSION}/odp
    install -m 755 ${S}/kern/odpfsl_kni.ko ${D}/lib/modules/${KERNEL_VERSION}/odp
}

SRC_URI += "file://0001-odp-module-add-txqueue-parameter-for-function-kni_ne.patch"

PKG_${PN} = "kernel-module-${PN}"
