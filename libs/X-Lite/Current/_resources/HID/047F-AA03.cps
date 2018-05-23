<?xml version="1.0" encoding="UTF-8" ?>
<settings version="1.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://www.counterpath.com/cps">
  <domain name="hid">

<!-- Plantronics C620 3, Plantronics C620-M 3, Plantronics C610 3, Plantronics C610-M 3 
	(0xAA00, 0xAA01, 0xAA02, 0xAA03) -->

    <section name="control0">
      <setting name="action" value="2"/>
      <setting name="id" value="0xFFA000B7"/>
      <setting name="name" value="talk"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control1">
      <setting name="action" value="5"/>
      <setting name="id" value="0xFFA000B5"/>
      <setting name="name" value="mute"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control2">
      <setting name="action" value="6"/>
      <setting name="id" value="0xFFA000B1"/>
      <setting name="name" value="volume up"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control3">
      <setting name="action" value="7"/>
      <setting name="id" value="0xFFA000B2"/>
      <setting name="name" value="volume down"/>
      <setting name="state" value="0"/>
    </section>

    <section name="indicator0">
      <setting name="action" value="9"/>
      <setting name="id" value="0xFFA0008F"/>
      <setting name="name" value="call started"/>
      <setting name="value" value="1"/>
    </section>
    <section name="indicator1">
      <setting name="action" value="10"/>
      <setting name="id" value="0xFFA0008F"/>
      <setting name="name" value="call ended"/>
      <setting name="value" value="0"/>
    </section>
    <section name="indicator2">
      <setting name="action" value="7"/>
      <setting name="id" value="0xFFA0008D"/>
      <setting name="name" value="startup"/>
      <setting name="value" value="1"/>
    </section>
    <section name="indicator3">
      <setting name="action" value="8"/>
      <setting name="id" value="0xFFA0008D"/>
      <setting name="name" value="shutdown"/>
      <setting name="value" value="0"/>
    </section>
    <section name="indicator4">
      <setting name="action" value="3"/>
      <setting name="id" value="0xFFA000B5"/>
      <setting name="name" value="mute"/>
      <setting name="value" value="1"/>
      <setting name="feature" value="1"/>
    </section>
    <section name="indicator5">
      <setting name="action" value="4"/>
      <setting name="id" value="0xFFA000B5"/>
      <setting name="name" value="unmute"/>
      <setting name="value" value="0"/>
      <setting name="feature" value="1"/>
    </section>
  </domain>
</settings>