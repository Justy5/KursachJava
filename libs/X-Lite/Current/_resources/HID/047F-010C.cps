<?xml version="1.0" encoding="UTF-8" ?>
<settings version="1.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://www.counterpath.com/cps">
  <domain name="hid">

<!-- Plantronics C710 (0x010C) -->

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
      <setting name="state" value="1"/>
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

    <section name="controlinfo0">
      <setting name="id" value="0xFFA000A1"/>
      <setting name="name" value="RF state"/>
      <setting name="usagetype" value="1"/>		<!-- ignore -->
    </section>

    <section name="indicator0">
      <setting name="action" value="11"/>
      <setting name="id" value="0xFFA000A1"/>
      <setting name="name" value="wake"/>
      <setting name="value" value="1"/>
      <setting name="feature" value="1"/>
    </section>
    <section name="indicator1">
      <setting name="action" value="12"/>
      <setting name="id" value="0xFFA000A1"/>
      <setting name="name" value="sleep"/>
      <setting name="value" value="0"/>
      <setting name="feature" value="1"/>
    </section>
    <section name="indicator2">
      <setting name="action" value="1"/>
      <setting name="id" value="0x000B009E"/>
      <setting name="name" value="ring on"/>
      <setting name="value" value="1"/>
    </section>
    <section name="indicator3">
      <setting name="action" value="2"/>
      <setting name="id" value="0x000B009E"/>
      <setting name="name" value="ring off"/>
      <setting name="value" value="0"/>
    </section>

    <section name="indicator4">
      <setting name="action" value="9"/>
      <setting name="id" value="0xFFA0008F"/>
      <setting name="name" value="call started"/>
      <setting name="value" value="1"/>
    </section>
    <section name="indicator5">
      <setting name="action" value="10"/>
      <setting name="id" value="0xFFA0008F"/>
      <setting name="name" value="call ended"/>
      <setting name="value" value="0"/>
    </section>
    <section name="indicator6">
      <setting name="action" value="7"/>
      <setting name="id" value="0xFFA0008D"/>
      <setting name="name" value="startup"/>
      <setting name="value" value="1"/>
    </section>
    <section name="indicator7">
      <setting name="action" value="8"/>
      <setting name="id" value="0xFFA0008D"/>
      <setting name="name" value="shutdown"/>
      <setting name="value" value="0"/>
    </section>
    <section name="indicator8">
      <setting name="action" value="3"/>
      <setting name="id" value="0xFFA000B5"/>
      <setting name="name" value="mute"/>
      <setting name="value" value="1"/>
    </section>
    <section name="indicator9">
      <setting name="action" value="4"/>
      <setting name="id" value="0xFFA000B5"/>
      <setting name="name" value="unmute"/>
      <setting name="value" value="0"/>
    </section>

    <section name="indicator">
      <setting name="ringtype" value="4"/>
    </section>

  </domain>
</settings>