<?xml version="1.0" encoding="UTF-8" ?>
<settings version="1.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://www.counterpath.com/cps">

<!-- PLTDDA60 -->

  <domain name="hid">
<!-- Nothing fires for un-mute so we can't do this as it'll get out of sync,
    <section name="control0">
      <setting name="action" value="5"/>
      <setting name="id" value="0x000C00E2"/>
      <setting name="name" value="mute"/>
      <setting name="state" value="0"/>
    </section>
-->
    <section name="control0">
      <setting name="action" value="6"/>
      <setting name="id" value="0x000C00E9"/>
      <setting name="name" value="volume up"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control1">
      <setting name="action" value="7"/>
      <setting name="id" value="0x000C00EA"/>
      <setting name="name" value="volume down"/>
      <setting name="state" value="0"/>
    </section>

    <section name="controlinfo0">
      <setting name="id" value="0xFF000001"/>
      <setting name="name" value="status?"/>
      <setting name="usagetype" value="1"/>
    </section>
  </domain>
</settings>