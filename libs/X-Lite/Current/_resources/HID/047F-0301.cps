<?xml version="1.0" encoding="UTF-8" ?>
<settings version="1.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://www.counterpath.com/cps">

<!-- Plantronics DSP-100 -->

  <domain name="hid">
    <section name="control0">
      <setting name="action" value="5"/>
      <setting name="id" value="0x000C00E2"/>
      <setting name="name" value="mute"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control1">
      <setting name="action" value="6"/>
      <setting name="id" value="0x000C00E9"/>
      <setting name="name" value="volume up"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control2">
      <setting name="action" value="7"/>
      <setting name="id" value="0x000C00EA"/>
      <setting name="name" value="volume down"/>
      <setting name="state" value="0"/>
    </section>

    <!-- The volume buttons repeat too fast so we'll treat them as toggle buttons 
         so we action on alternating events -->
    <section name="controlinfo0">
      <setting name="id" value="0x000C00E9"/>
      <setting name="name" value="volume up"/>
      <setting name="usagetype" value="3"/>
    </section>
    <section name="controlinfo1">
      <setting name="id" value="0x000C00EA"/>
      <setting name="name" value="volume down"/>
      <setting name="usagetype" value="3"/>
    </section>
  </domain>
</settings>