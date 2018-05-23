<?xml version="1.0" encoding="UTF-8" ?>
<settings version="1.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://www.counterpath.com/cps">
  <domain name="hid">

<!-- Jabra file information: -->
<!-- Product: Jabra UC VOICE 550, File version: 1.00.00 -->
<!-- This file has been tested using the following parameters/setup: -->
<!-- CounterPath product: Bria 3, FW/SW release: 3.2.1 -->
<!-- Operating system: Windows XP, Latest SP -->
<!-- Jabra product details: FW release: Latest, PID: 0031 , Friendly name: Jabra UC VOICE 550 mono USB -->

    <section name="control0">
      <setting name="action" value="0"/>
      <setting name="id" value="0x000B0020"/>
      <setting name="name" value="off-hook"/>
      <setting name="state" value="1"/>
    </section>
<!-- DRL I use answer/hangup for the following so we properly handle the case of
     an incoming call while we're in a call (answer the incoming instead of hangup the active) -->
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
      <setting name="id" value="0x00080009"/>
      <setting name="name" value="mute"/>
      <setting name="value" value="1"/>
    </section>
    <section name="indicator3">
      <setting name="action" value="4"/>
      <setting name="id" value="0x00080009"/>
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
    </section>

  </domain>
</settings>                  