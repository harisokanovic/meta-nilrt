# (C) Copyright 2013,
#  National Instruments Corporation.
#  All rights reserved.

SUMMARY = "Base set of packages for NI Linux Realtime distribution"
LICENSE = "MIT"
PR = "r1"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

#
# Set by the machine configuration with packages essential for device bootup
#
MACHINE_ESSENTIAL_EXTRA_RDEPENDS ?= ""
MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS ?= ""

RDEPENDS_${PN} = "\
	avahi-daemon \
	avahi-dnsconfd \
	base-files \
	base-passwd \
	${@base_contains("MACHINE_FEATURES", "keyboard", "keymaps", "", d)} \
	busybox \
	busybox-ifplugd \
	${@base_contains("MACHINE_FEATURES", "acpi", "busybox-acpid", "", d)} \
	coreutils-hostname \
	dhcp-client \
	dmidecode \
	e2fsprogs \
	e2fsprogs-mke2fs \
	ethtool \
	glibc-gconv-utf-16 \
	gptfdisk-sgdisk \
	init-ifupdown \
	initscripts \
	iproute2 \
	iptables \
	kmod \
	libavahi-client \
	libavahi-common \
	libavahi-core \
	libcap-bin \
	libnss-mdns \
	libpam \
	libstdc++ \
	mtd-utils \
	mtd-utils-ubifs \
	netbase \
	niacctbase \
	openssh-sshd \
	openssh-scp \
	openssh-sftp-server \
	openssh-sftp \
	openssh-ssh \
	openvpn \
	opkg \
	pigz \
	syslog-ng \
	sysvinit \
	tar \
	util-linux-findfs \
	util-linux-hwclock \
	util-linux-mount \
	util-linux-umount \
	${VIRTUAL-RUNTIME_dev_manager} \
	${MACHINE_ESSENTIAL_EXTRA_RDEPENDS}"

RRECOMMENDS_${PN} = "\
	${MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS}"
