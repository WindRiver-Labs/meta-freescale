SUMMARY = "Open Data Plane Interface Implementation"
DESCRIPTION = "OpenDataPlane (ODP) provides a data plane application programming \
        environment that is easy to use, high performance, and portable between networking SoCs."
HOMEPAGE = "http://www.opendataplane.org"
SECTION = "console/network"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ca6103dc75397fb6bec596187d6b7829"

FILESEXTRAPATHS_prepend := "${THISDIR}/odp:"

SRC_URI = " \
git://source.codeaurora.org/external/qoriq/qoriq-components/odp;nobranch=1 \
git://source.codeaurora.org/external/qoriq/qoriq-components/qbman_userspace;nobranch=1;name=qbman;destsuffix=git/platform/linux-dpaa2/flib/qbman \
git://source.codeaurora.org/external/qoriq/qoriq-components/flib;nobranch=1;name=rta;destsuffix=git/platform/linux-dpaa2/flib/rta \
"

SRC_URI += "file://0001-Fix-this-build-error.patch \
	    file://0002-fsl_mc_sys.h-drop-no-existed-file-libio.h.patch \
	    file://0001-qbman-move-the-qman_version-define-into-c-file.patch \
	    file://0001-odp-api-define-ODP_ALIGNED_CACHE-macro.patch \
	    file://0001-test-validation-assert-seq-with-static.patch \
	    file://0001-example-lpm-ipfwd-assert-FSL_CRC64_ECMA_182-with-sta.patch \
	    file://0001-odp-lpm-ipfwd-assert-dev_map_list-with-static.patch"

SRCREV = "0bda2c9736a72ef41a411e193bc31487ecce6731"

SRCREV_qbman = "75ff61a7ca6acdbdbb780161b053cbcbc990f1be"
SRCREV_rta = "bbab28b03ae21c52ce913f8b052acf53bd24ff5d"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "(ls1043a|ls1046a|ls2080a|ls2088a|ls1088a)"
