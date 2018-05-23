<?xml version="1.0" encoding="UTF-8" ?>
<settings version="1.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://www.counterpath.com/cps">
  <domain name="hid">

<!-- Plantronics Calisto P240 -->

    <section name="control0">
      <setting name="action" value="2"/>
      <setting name="id" value="0xFFA000B7"/>
      <setting name="name" value="talk"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control1">
      <setting name="action" value="6"/>
      <setting name="id" value="0xFFA000B1"/>
      <setting name="name" value="volume up"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control2">
      <setting name="action" value="7"/>
      <setting name="id" value="0xFFA000B2"/>
      <setting name="name" value="volume down"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control3">
      <setting name="action" value="4"/>
      <setting name="id" value="0xFFA000B3"/>
      <setting name="name" value="long volume up / hold/resume"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control4">
      <setting name="action" value="5"/>
      <setting name="id" value="0xFFA000B5"/>
      <setting name="name" value="long volume down / mute toggle"/>
      <setting name="state" value="0"/>
    </section>
    <!-- When the device is off-hook hitting the talk button simply turns off the audio channel 
         so we have to treat this as a hook switch -->
    <section name="control5">
      <setting name="action" value="2"/>
      <setting name="id" value="0xFFA000A1"/>
      <setting name="name" value="hook switch"/>
      <setting name="state" value="0"/>
    </section>


<!-- DRL FIXIT? I don't know what these are so for the time being we'll ignore them (don't allow mapping them) as they get fired a lot -->
    <section name="controlinfo0">
      <setting name="id" value="0xFFA00080"/>
      <setting name="name" value="unknown"/>
      <setting name="usagetype" value="1"/>
    </section>
    <section name="controlinfo1">
      <setting name="id" value="0xFFA00081"/>
      <setting name="name" value="unknown"/>
      <setting name="usagetype" value="1"/>
    </section>
    <section name="controlinfo2">
      <setting name="id" value="0xFFA000D5"/>
      <setting name="name" value="unknown"/>
      <setting name="usagetype" value="1"/>
    </section>
    <section name="controlinfo3">
      <setting name="id" value="0xFFA000F8"/>
      <setting name="name" value="unknown"/>
      <setting name="usagetype" value="1"/>
    </section>
    <section name="controlinfo4">
      <setting name="id" value="0xFFA000F9"/>
      <setting name="name" value="unknown"/>
      <setting name="usagetype" value="1"/>
    </section>

    <section name="indicator0">
      <setting name="action" value="11"/>
      <setting name="id" value="0xFFA000A1"/>
      <setting name="name" value="wake"/>
      <setting name="value" value="1"/>
    </section>
    <section name="indicator1">
      <setting name="action" value="12"/>
      <setting name="id" value="0xFFA000A1"/>
      <setting name="name" value="sleep"/>
      <setting name="value" value="0"/>
    </section>
    <section name="indicator2">
      <setting name="action" value="9"/>
      <setting name="id" value="0xFFA0008F"/>
      <setting name="name" value="call started"/>
      <setting name="value" value="1"/>
    </section>
    <section name="indicator3">
      <setting name="action" value="10"/>
      <setting name="id" value="0xFFA0008F"/>
      <setting name="name" value="call ended"/>
      <setting name="value" value="0"/>
    </section>
    <section name="indicator4">
      <setting name="action" value="7"/>
      <setting name="id" value="0xFFA0008D"/>
      <setting name="name" value="startup"/>
      <setting name="value" value="1"/>
    </section>
    <section name="indicator5">
      <setting name="action" value="8"/>
      <setting name="id" value="0xFFA0008D"/>
      <setting name="name" value="shutdown"/>
      <setting name="value" value="0"/>
    </section>
    <section name="indicator6">
      <setting name="action" value="3"/>
      <setting name="id" value="0xFFA000B5"/>
      <setting name="name" value="mute"/>
      <setting name="value" value="1"/>
      <setting name="feature" value="1"/>
    </section>
    <section name="indicator7">
      <setting name="action" value="4"/>
      <setting name="id" value="0xFFA000B5"/>
      <setting name="name" value="unmute"/>
      <setting name="value" value="0"/>
      <setting name="feature" value="1"/>
    </section>
    <section name="indicator8">
      <setting name="action" value="1"/>
      <setting name="id" value="0xFFA0009E"/>
      <setting name="name" value="ring on"/>
      <setting name="value" value="1"/>
    </section>
    <section name="indicator9">
      <setting name="action" value="2"/>
      <setting name="id" value="0xFFA0009E"/>
      <setting name="name" value="ring off"/>
      <setting name="value" value="0"/>
    </section>

    <section name="indicator">
      <setting name="ringtype" value="4"/>
    </section>

  </domain>
</settings>