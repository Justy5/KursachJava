<?xml version="1.0" encoding="UTF-8" ?>
<settings version="1.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://www.counterpath.com/cps">
  <domain name="hid">

<!-- Jabra file information: -->
<!-- Product: GN8120 USB, File version: 1.00.00 -->
<!-- This file has been tested using the following parameters/setup: -->
<!-- CounterPath product: ?? File constructed by CounterPath -->
<!-- Operating system: ?? -->
<!-- Jabra product details: Legacy product - no longer produced -->

    <section name="control0">
      <setting name="action" value="2"/>
      <setting name="id" value="0x000B0020"/>
      <setting name="name" value="green - hook switch"/>
      <setting name="state" value="1"/>
    </section>
    <section name="control1">
      <setting name="action" value="4"/>
      <setting name="id" value="0x000B0070"/>
      <setting name="name" value="white - hold"/>
      <setting name="state" value="1"/>
    </section>
    <section name="control2">
      <setting name="action" value="5"/>
      <setting name="id" value="0x000B002F"/>
      <setting name="name" value="red - mute"/>
      <setting name="state" value="1"/>
    </section>
    <section name="control3">
      <setting name="action" value="6"/>
      <setting name="id" value="0x000C00E9"/>
      <setting name="name" value="volume up"/>
      <setting name="state" value="1"/>
    </section>
    <section name="control4">
      <setting name="action" value="7"/>
      <setting name="id" value="0x000C00EA"/>
      <setting name="name" value="volume down"/>
      <setting name="state" value="1"/>
    </section>

    <!-- The volume buttons repeat too fast so we'll treat them as on/off buttons
         which helps because button up events are not fired while you hold them down -->
    <section name="controlinfo0">
      <setting name="id" value="0x000C00E9"/>
      <setting name="name" value="volume up"/>
      <setting name="usagetype" value="2"/>
    </section>
    <section name="controlinfo1">
      <setting name="id" value="0x000C00EA"/>
      <setting name="name" value="volume down"/>
      <setting name="usagetype" value="2"/>
    </section>

    <section name="indicator0">
      <setting name="action" value="3"/>
      <setting name="id" value="0x00080021"/>
      <setting name="name" value="mute"/>
      <setting name="value" value="1"/>
    </section>
    <section name="indicator1">
      <setting name="action" value="4"/>
      <setting name="id" value="0x00080021"/>
      <setting name="name" value="unmute"/>
      <setting name="value" value="0"/>
    </section>
    <section name="indicator2">
      <setting name="action" value="5"/>
      <setting name="id" value="0x00080017"/>
      <setting name="name" value="on-hook"/>
      <setting name="value" value="0"/>
    </section>
    <section name="indicator3">
      <setting name="action" value="6"/>
      <setting name="id" value="0x00080017"/>
      <setting name="name" value="off-hook"/>
      <setting name="value" value="1"/>
    </section>
<!--- Make sure the device is sending USB.org values and not GN Netcom specific 
      values - this helps avoid conflict with Jabra PC Suite. -->
    <section name="indicator4">
      <setting name="action" value="7"/>
      <setting name="id" value="0xFF30FFFF"/>
      <setting name="name" value="startup"/>
      <setting name="value" value="0"/>
    </section>
    <section name="indicator5">
      <setting name="action" value="9"/>
      <setting name="id" value="0xFF30FFFF"/>
      <setting name="name" value="call started"/>
      <setting name="value" value="0"/>
    </section>
  </domain>
</settings>                     