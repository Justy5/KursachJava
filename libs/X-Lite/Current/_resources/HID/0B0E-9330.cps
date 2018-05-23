<?xml version="1.0" encoding="UTF-8" ?>
<settings version="1.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://www.counterpath.com/cps">
  <domain name="hid">

<!-- Jabra file information: -->
<!-- Product: GN 9330 (reporting HID version 0100), File version: 1.00.00 -->
<!-- This file has been tested using the following parameters/setup: -->
<!-- CounterPath product: Bria 3, FW/SW release: 3.1.3 RC1 build 58878 -->
<!-- Operating system: Windows 7 Enterprise, SW release: 6.1.7600 -->
<!-- Jabra product details: FW release: 1.33, PID: 9330, P/N: 9337-509-401 -->

    <section name="control0">
      <setting name="action" value="2"/>
      <setting name="id" value="0x000B0020"/>
      <setting name="name" value="hook switch"/>
      <setting name="state" value="1"/>
    </section>
    <section name="control1">
      <setting name="action" value="5"/>
      <setting name="id" value="0x000B002F"/>
      <setting name="name" value="mute"/>
      <setting name="state" value="1"/>
    </section>
    <section name="control2">
      <setting name="action" value="6"/>
      <setting name="id" value="0x000B00E9"/>
      <setting name="name" value="volume up"/>
      <setting name="state" value="1"/>
    </section>
    <section name="control3">
      <setting name="action" value="7"/>
      <setting name="id" value="0x000B00EA"/>
      <setting name="name" value="volume down"/>
      <setting name="state" value="1"/>
    </section>

    <section name="indicator0">
      <setting name="action" value="1"/>
      <setting name="id" value="0x000B009E"/>
      <setting name="name" value="ringon"/>
      <setting name="value" value="1"/>
    </section>
    <section name="indicator1">
      <setting name="action" value="2"/>
      <setting name="id" value="0x000B009E"/>
      <setting name="name" value="ringoff"/>
      <setting name="value" value="0"/>
    </section>
    <section name="indicator2">
      <setting name="action" value="3"/>
      <setting name="id" value="0x00080021"/>
      <setting name="name" value="mute"/>
      <setting name="value" value="1"/>
    </section>
    <section name="indicator3">
      <setting name="action" value="4"/>
      <setting name="id" value="0x00080021"/>
      <setting name="name" value="unmute"/>
      <setting name="value" value="0"/>
    </section>
    <section name="indicator4">
      <setting name="action" value="11"/>
      <setting name="id" value="0x0008002A"/>
      <setting name="name" value="wake"/>
      <setting name="value" value="-1"/>
    </section>
    <section name="indicator5">
      <setting name="action" value="12"/>
      <setting name="id" value="0x0008002B"/>
      <setting name="name" value="sleep"/>
      <setting name="value" value="-1"/>
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
      <setting name="ringtype" value="0"/>
    </section>
  </domain>
</settings>              