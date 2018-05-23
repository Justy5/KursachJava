<?xml version="1.0" encoding="UTF-8" ?>
<settings version="1.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://www.counterpath.com/cps">
  <domain name="hid">

<!-- Jabra file information: -->
<!-- Product: PRO 9470, File version: 1.00.00 -->
<!-- This file has been tested using the following parameters/setup: -->
<!-- CounterPath product: Bria 3, FW/SW release: 3.1.3 RC1 build 58878 -->
<!-- Operating system: Windows 7 Enterprise, SW release: 6.1.7600 -->
<!-- Jabra product details: FW release: 1.49.14, PID: 1041, Friendly name: Jabra PRO 9470, P/N: 9460-25-707-101 -->

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
      <setting name="action" value="4"/>
      <setting name="id" value="0x000B0021"/>
      <setting name="name" value="accept second call / hold / resume"/>
      <setting name="state" value="1"/>
    </section>
    <section name="control3">
      <setting name="action" value="28"/>
      <setting name="id" value="0x00090007"/>
      <setting name="name" value="reject second call"/>
      <setting name="state" value="1"/>
    </section>
    <section name="control4">
      <setting name="action" value="5"/>
      <setting name="id" value="0x000B002F"/>
      <setting name="name" value="mute"/>
      <setting name="state" value="1"/>
    </section>

    <section name="controlinfo0">
      <setting name="id" value="0x000B002A"/>
      <setting name="name" value="audio channel open"/>
      <setting name="usagetype" value="1"/>
    </section>
    <section name="controlinfo1">
      <setting name="id" value="0x000B0097"/>
      <setting name="name" value="line busy?"/>
      <setting name="usagetype" value="1"/>
    </section>
    <section name="controlinfo2">
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
    <section name="indicator6">
      <setting name="action" value="11"/>
      <setting name="id" value="0x0008002A"/>
      <setting name="name" value="wake"/>
      <setting name="value" value="1"/>
    </section>
    <section name="indicator7">
      <setting name="action" value="12"/>
      <setting name="id" value="0x0008002A"/>
      <setting name="name" value="sleep"/>
      <setting name="value" value="0"/>
    </section>
    <section name="indicator8">
      <setting name="action" value="17"/>	<!-- any call -->
      <setting name="id" value="0x00080020"/>
      <setting name="name" value="hold on"/>
      <setting name="value" value="1"/>
    </section>
    <section name="indicator9">
      <setting name="action" value="18"/>
      <setting name="id" value="0x00080020"/>
      <setting name="name" value="hold off"/>
      <setting name="value" value="0"/>
    </section>
<!--- Make sure the device is sending USB.org values and not GN Netcom specific 
      values - this helps avoid conflict with Jabra PC Suite. -->
    <section name="indicator10">
      <setting name="action" value="7"/>
      <setting name="id" value="0xFF30FFFF"/>
      <setting name="name" value="startup"/>
      <setting name="value" value="0"/>
    </section>
    <section name="indicator11">
      <setting name="action" value="9"/>
      <setting name="id" value="0xFF30FFFF"/>
      <setting name="name" value="call started"/>
      <setting name="value" value="0"/>
    </section>

    <section name="indicator">
      <setting name="ringtype" value="4"/>
      <setting name="callwaitingtype" value="1"/>
      <setting name="togglehook" value="1"/>
      <setting name="togglemute" value="1"/>
    </section>
  </domain>
</settings>             