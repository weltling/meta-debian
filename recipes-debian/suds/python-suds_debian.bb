SUMMARY = "Lightweight SOAP client for Python"
DISCRIPTION = "\
	The suds project is a Python soap web services client lib. \
	Suds leverages Python meta programming to provide an intuitive API \
	for consuming web services. Objectification of types defined in \
	the WSDL is provided without class generation. Programmers rarely \
	need to read the WSDL since services and WSDL based objects can be \
	easily inspected. Supports pluggable soap bindings."

LICENSE = "LGPL-3.0+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=847e96bce86d8774f491a92924343a29"

PR = "r0"
DPN = "suds"

DEPENDS += "python-setuptools-native"

inherit debian-package
inherit distutils
PV = "0.4.1"

KEEP_NONARCH_BASELIB = "1"

DISTUTILS_INSTALL_ARGS += " \
	--root='${D}' \
	--prefix='${prefix}' \
	--install-lib='${PYTHON_SITEPACKAGES_DIR}' \
	--install-data='${datadir}'"

# required by distutils/sysconfig.py to get config dir
export DEB_HOST_MULTIARCH

do_install_append() {
	# Remove unwanted files and folders
	find ${D}${PYTHON_SITEPACKAGES_DIR} -type f -name "*.pyc" -exec rm -f {} \;
	find ${D}${PYTHON_SITEPACKAGES_DIR} -type f -name "*.pyo" -exec rm -f {} \;
	find ${D}${PYTHON_SITEPACKAGES_DIR} -type f -name "SOURCES.txt" -exec rm -f {} \;
}

BBCLASSEXTEND = "native"
