<?xml version="1.0" encoding="UTF-8" ?>
<settings version="1.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://www.counterpath.com/cps">
  <domain name="hid">

<!-- Sennheiser DECT (CUBE, DW Office) -->

    <section name="control0">
      <setting name="action" value="2"/>
      <setting name="id" value="0x000B0020"/>
      <setting name="name" value="talk"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control1">
      <setting name="action" value="2"/>
      <setting name="id" value="0x000B0020"/>
      <setting name="name" value="talk"/>
      <setting name="state" value="1"/>
    </section>
    <section name="control2">
      <setting name="action" value="5"/>
      <setting name="id" value="0x000B002F"/>
      <setting name="name" value="mute toggle"/>
      <setting name="state" value="0"/>
    </section>

<!-- volume keys don't fire on this interface and the device doesn't seem 
     to have drop and redial buttons -->

    <section name="controlinfo0">
      <setting name="id" value="0x000B0020"/>
      <setting name="name" value="hook state"/>
      <setting name="usagetype" value="2"/>
    </section>

    <section name="indicator0">
      <setting name="action" value="11"/>
      <setting name="id" value="0x00080017"/>
      <setting name="name" value="wake"/>
      <setting name="value" value="1"/>
    </section>
    <section name="indicator1">
      <setting name="action" value="12"/>
      <setting name="id" value="0x00080017"/>
      <setting name="name" value="sleep"/>
      <setting name="value" value="0"/>
    </section>
    <section name="indicator2">
      <setting name="action" value="6"/>
      <setting name="id" value="0x0008002A"/>
      <setting name="name" value="off hook"/>
      <setting name="value" value="1"/>
    </section>
    <section name="indicator3">
      <setting name="action" value="5"/>
      <setting name="id" value="0x0008002A"/>
      <setting name="name" value="on hook"/>
      <setting name="value" value="0"/>
    </section>
    <section name="indicator4">
      <setting name="action" value="3"/>
      <setting name="id" value="0x00080009"/>
      <setting name="name" value="mute"/>
      <setting name="value" value="1"/>
    </section>
    <section name="indicator5">
      <setting name="action" value="4"/>
      <setting name="id" value="0x00080009"/>
      <setting name="name" value="unmute"/>
      <setting name="value" value="0"/>
    </section>
    <section name="indicator6">
      <setting name="action" value="1"/>
      <setting name="id" value="0x00080018"/>
      <setting name="name" value="ring on"/>
      <setting name="value" value="1"/>
    </section>
    <section name="indicator7">
      <setting name="action" value="2"/>
      <setting name="id" value="0x00080018"/>
      <setting name="name" value="ring off"/>
      <setting name="value" value="0"/>
    </section>

    <section name="indicator">
<!-- I sometimes heard the device ring but it was very rare, not sure how to get it to ring consistently -->
      <setting name="ringtype" value="1"/>
      <setting name="callwaitingtype" value="1"/>
<!-- The wake and mute sometimes did not take effect unless they were first set to OFF before ON -->
      <setting name="togglewake" value="1"/>
      <setting name="togglemute" value="1"/>
    </section>
  </domain>
</settings>