<?xml version="1.0" encoding="UTF-8" ?>
<settings version="1.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://www.counterpath.com/cps">
  <domain name="hid">

<!-- CS50/CS60-USB Headset (Legacy BellRinger, 0x410) -->

<!-- The A1 seems to be the ON/OFF state - Ramesh says dock/undock events aren't supported. 
    <section name="control0">
      <setting name="action" value="1"/>
      <setting name="id" value="0xFFA000A1"/>
      <setting name="name" value="on hook"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control1">
      <setting name="action" value="2"/>
      <setting name="id" value="0xFFA000A1"/>
      <setting name="name" value="off hook"/>
      <setting name="state" value="1"/>
    </section>
-->
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
    <section name="control4">
      <setting name="action" value="4"/>
      <setting name="id" value="0xFFA000B3"/>
      <setting name="name" value="long volume up / hold/resume"/>
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

    <section name="indicator">
      <setting name="ringtype" value="4"/>
    </section>

  </domain>
</settings>