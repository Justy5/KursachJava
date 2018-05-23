<?xml version="1.0" encoding="UTF-8" ?>
<settings version="1.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://www.counterpath.com/cps">
  <domain name="hid">

<!-- Jabra file information: -->
<!-- Product: Jabra UC VOICE 750 MS mono USB, File version: 1.00.00 -->
<!-- CounterPath product: Bria 3, FW/SW release: 3.5.3 -->
<!-- Jabra product details: FW release: Latest, PID: 0753,Friendly name: Jabra UC VOICE 750 MS mono USB -->

    <section name="control0">
      <setting name="action" value="0"/>
      <setting name="id" value="0x000B0020"/>
      <setting name="name" value="off-hook"/>
      <setting name="state" value="1"/>
    </section>
    <section name="control1">
      <setting name="action" value="2"/>
      <setting name="id" value="0x000B0020"/>
      <setting name="name" value="on-hook"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control2">
      <setting name="action" value="5"/>
      <setting name="id" value="0x000B002F"/>
      <setting name="name" value="mute"/>
      <setting name="state" value="1"/>
    </section>
    <section name="control3">
      <setting name="action" value="3"/>
      <setting name="id" value="0x000C00E9"/>
      <setting name="name" value="volume up"/>
      <setting name="state" value="1"/>
    </section>
    <section name="control4">
      <setting name="action" value="4"/>
      <setting name="id" value="0x000C00EA"/>
      <setting name="name" value="volume down"/>
      <setting name="state" value="1"/>
    </section>

     <section name="controlinfo0">
      <setting name="id" value="0x000B0020"/>
      <setting name="name" value="hook state"/>
      <setting name="usagetype" value="2"/>
    </section>

    <section name="indicator0">
      <setting name="action" value="1"/>
      <setting name="id" value="0x00080018"/>
      <setting name="name" value="ring on"/>
      <setting name="value" value="1"/>
    </section>
    <section name="indicator1">
      <setting name="action" value="2"/>
      <setting name="id" value="0x00080018"/>
      <setting name="name" value="ring off"/>
      <setting name="value" value="0"/>
    </section>
   <section name="indicator2">
      <setting name="action" value="3"/>
      <setting name="id" value="0x00080021"/>
      <setting name="name" value="mute"/>
      <setting name="value" value="1"/>
    </section>
    <section name="indicator3">
      <setting name="action" value="4"/>
      <setting name="id" value="0x00080021"/>
      <setting name="name" value="unmute"/>
      <setting name="value" value="0"/>
    </section>
    <section name="indicator4">
      <setting name="action" value="5"/>
      <setting name="id" value="0x00080017"/>
      <setting name="name" value="on-hook"/>
      <setting name="value" value="0"/>
    </section>
    <section name="indicator5">
      <setting name="action" value="6"/>
      <setting name="id" value="0x00080017"/>
      <setting name="name" value="off-hook"/>
      <setting name="value" value="1"/>
    </section>

    <section name="indicator">
      <setting name="ringtype" value="1"/>
	  <setting name="callwaitingtype" value="1"/>
    </section>

  </domain>
</settings>                              