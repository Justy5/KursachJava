<?xml version="1.0" encoding="UTF-8" ?>
<settings version="1.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://www.counterpath.com/cps">

<!-- Avnera / Freetalk -->
<!-- Mike Padmore <mike.padmore@ebuynow.com> confirmed with his technical contact 
     that this device does not support the "Link" button via HID -->

  <domain name="hid">
    <section name="control0">
      <setting name="action" value="6"/>
      <setting name="id" value="0x000C00E9"/>
      <setting name="name" value="Volume up"/>
      <setting name="state" value="1"/>
    </section>
    <section name="control1">
      <setting name="action" value="7"/>
      <setting name="id" value="0x000C00EA"/>
      <setting name="name" value="Volume down"/>
      <setting name="state" value="1"/>
    </section>
  </domain>
</settings>