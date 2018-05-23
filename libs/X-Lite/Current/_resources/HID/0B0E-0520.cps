<?xml version="1.0" encoding="UTF-8" ?>
<settings version="1.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://www.counterpath.com/cps">
  <domain name="hid">

<!-- Jabra file information: -->
<!-- Product: DIAL 520, File version: 1.00.00 -->
<!-- This file has been tested using the following parameters/setup: -->
<!-- CounterPath product: Bria 3, FW/SW release: 3.1.3 RC1 build 58878 -->
<!-- Operating system: Windows 7 Enterprise, SW release: 6.1.7600 -->
<!-- Jabra product details: FW release: 1.0, PID: 0520, P/N: 7521-09 -->

    <section name="control0">
      <setting name="action" value="0"/>
      <setting name="id" value="0x000B0020"/>
      <setting name="name" value="off hook"/>
      <setting name="state" value="1"/>
    </section>
<!-- DRL When you press the on-hook button while the device is on-hook you get this fired (1 then 0): -->
    <section name="control1">
      <setting name="action" value="1"/>
      <setting name="id" value="0x000B0021"/>
      <setting name="name" value="off hook 2"/>
      <setting name="state" value="1"/>
    </section>
    <section name="control2">
      <setting name="action" value="1"/>
      <setting name="id" value="0x000B0020"/>
      <setting name="name" value="on hook"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control3">
      <setting name="action" value="31"/>
      <setting name="id" value="0x00090007"/>
      <setting name="name" value="key C (backspace / reject)"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control4">
      <setting name="action" value="8"/>
      <setting name="id" value="0x000B00B0"/>
      <setting name="name" value="key 0"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control5">
      <setting name="action" value="9"/>
      <setting name="id" value="0x000B00B1"/>
      <setting name="name" value="key 1"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control6">
      <setting name="action" value="10"/>
      <setting name="id" value="0x000B00B2"/>
      <setting name="name" value="key 2"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control7">
      <setting name="action" value="11"/>
      <setting name="id" value="0x000B00B3"/>
      <setting name="name" value="key 3"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control8">
      <setting name="action" value="12"/>
      <setting name="id" value="0x000B00B4"/>
      <setting name="name" value="key 4"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control9">
      <setting name="action" value="13"/>
      <setting name="id" value="0x000B00B5"/>
      <setting name="name" value="key 5"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control10">
      <setting name="action" value="14"/>
      <setting name="id" value="0x000B00B6"/>
      <setting name="name" value="key 6"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control11">
      <setting name="action" value="15"/>
      <setting name="id" value="0x000B00B7"/>
      <setting name="name" value="key 7"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control12">
      <setting name="action" value="16"/>
      <setting name="id" value="0x000B00B8"/>
      <setting name="name" value="key 8"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control13">
      <setting name="action" value="17"/>
      <setting name="id" value="0x000B00B9"/>
      <setting name="name" value="key 9"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control14">
      <setting name="action" value="18"/>
      <setting name="id" value="0x000B00BA"/>
      <setting name="name" value="key *"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control15">
      <setting name="action" value="19"/>
      <setting name="id" value="0x000B00BB"/>
      <setting name="name" value="key #"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control16">
      <setting name="action" value="22"/>
      <setting name="id" value="0x000B002F"/>
      <setting name="name" value="mute on"/>
      <setting name="state" value="1"/>
    </section>
    <section name="control17">
      <setting name="action" value="23"/>
      <setting name="id" value="0x000B002F"/>
      <setting name="name" value="mute off"/>
      <setting name="state" value="0"/>
    </section>

    <section name="controlinfo0">
      <setting name="id" value="0x000B0020"/>
      <setting name="name" value="hook switch"/>
      <setting name="usagetype" value="2"/>
    </section>
<!--
    <section name="controlinfo1">
      <setting name="id" value="0x000B0021"/>
      <setting name="name" value="unknown"/>
      <setting name="usagetype" value="1"/>
    </section>
-->

    <section name="control">
      <setting name="playsdtmf" value="0"/>
    </section>

    <section name="indicator0">
      <setting name="action" value="1"/>
      <setting name="id" value="0x00080018"/>
      <setting name="name" value="ring on"/>
      <setting name="value" value="1"/>
    </section>
    <section name="indicator1">
      <setting name="action" value="2"/>
      <setting name="id" value="0x00080018"/>
      <setting name="name" value="ring off"/>
      <setting name="value" value="0"/>
    </section>
    <section name="indicator2">
      <setting name="action" value="3"/>
      <setting name="id" value="0x00080009"/>
      <setting name="name" value="mute"/>
      <setting name="value" value="1"/>
    </section>
    <section name="indicator3">
      <setting name="action" value="4"/>
      <setting name="id" value="0x00080009"/>
      <setting name="name" value="unmute"/>
      <setting name="value" value="0"/>
    </section>
    <section name="indicator4">
      <setting name="action" value="5"/>
      <setting name="id" value="0x00080017"/>
      <setting name="name" value="on-hook"/>
      <setting name="value" value="0"/>
    </section>
    <section name="indicator5">
      <setting name="action" value="6"/>
      <setting name="id" value="0x00080017"/>
      <setting name="name" value="off-hook"/>
      <setting name="value" value="1"/>
    </section>
<!--- Make sure the device is sending USB.org values and not GN Netcom specific 
      values - this helps avoid conflict with Jabra PC Suite. -->
    <section name="indicator6">
      <setting name="action" value="7"/>
      <setting name="id" value="0xFF30FFFF"/>
      <setting name="name" value="startup"/>
      <setting name="value" value="0"/>
    </section>
    <section name="indicator7">
      <setting name="action" value="9"/>
      <setting name="id" value="0xFF30FFFF"/>
      <setting name="name" value="call started"/>
      <setting name="value" value="0"/>
    </section>

    <section name="indicator">
      <setting name="ringtype" value="1"/>
<!-- DRL If we flash the screen for call waiting then you can't hang up the active call (no event sent for on-hook).
      <setting name="callwaitingtype" value="1"/>
-->
    </section>
  </domain>
</settings> 