<?xml version="1.0" encoding="UTF-8" ?>
<settings version="1.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://www.counterpath.com/cps">

<!-- DA-45, DA45 Adapter, Plantronics DA45, Plantronics DA45-M, Plantronics DA45 Stereo, Plantronics DA45-M Stereo, Platronics DA40 
	(0xAA00, 0xAA01, 0xAA02, 0xAA03, 0xAA05, 0xAA06, 0xAA07, 0xAA08, 0xAA09) -->

  <domain name="hid">
    <section name="control0">
      <setting name="action" value="2"/>
      <setting name="id" value="0xFFA000B7"/>
      <setting name="name" value="headset on"/>
      <setting name="state" value="1"/>
    </section>
    <section name="control1">
      <setting name="action" value="2"/>
      <setting name="id" value="0xFFA000B7"/>
      <setting name="name" value="headset off"/>
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
    <section name="control4">
      <setting name="action" value="22"/>
      <setting name="id" value="0xFFA000B5"/>
      <setting name="name" value="mute on"/>
      <setting name="state" value="1"/>
    </section>
    <section name="control5">
      <setting name="action" value="23"/>
      <setting name="id" value="0xFFA000B5"/>
      <setting name="name" value="mute off"/>
      <setting name="state" value="0"/>
    </section>

    <section name="controlinfo0">
      <setting name="id" value="0xFFA000B7"/>
      <setting name="name" value="headset"/>
      <setting name="usagetype" value="2"/>
    </section>
    <section name="controlinfo1">
      <setting name="id" value="0xFFA000B5"/>
      <setting name="name" value="mute"/>
      <setting name="usagetype" value="2"/>
    </section>
  </domain>
</settings>