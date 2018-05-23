<?xml version="1.0" encoding="UTF-8" ?>
<settings version="1.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://www.counterpath.com/cps">
  <domain name="hid">

<!-- Logitech H820e Dual -->

    <section name="controlinfo0">
      <setting name="id" value="0x000B0020"/>
      <setting name="name" value="hook state"/>
      <setting name="usagetype" value="Momentary"/>
      <setting name="ignoreCount" value="1"/>
    </section>
    <section name="controlinfo1">
      <setting name="id" value="0x000B002F"/>
      <setting name="name" value="mute toggle"/>
      <setting name="usagetype" value="Momentary"/>
    </section>
    <section name="controlinfo2">
      <setting name="id" value="0x000C00E9"/>
      <setting name="name" value="volume up"/>
      <setting name="usagetype" value="OnOff3"/>
      <setting name="ignoreCount" value="2"/>
    </section>
    <section name="controlinfo3">
      <setting name="id" value="0x000C00EA"/>
      <setting name="name" value="volume down"/>
      <setting name="usagetype" value="OnOff3"/>
      <setting name="ignoreCount" value="2"/>
    </section>

    <section name="control0">
      <setting name="action" value="Answer"/>
      <setting name="id" value="0x000B0020"/>
      <setting name="name" value="talk"/>
      <setting name="state" value="1"/>
    </section>
    <section name="control1">
      <setting name="action" value="AnswerHangup"/>
      <setting name="id" value="0x000B0020"/>
      <setting name="name" value="talk"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control2">
      <setting name="action" value="MuteUnmuteToggle"/>
      <setting name="id" value="0x000B002F"/>
      <setting name="name" value="mute toggle"/>
      <setting name="state" value="1"/>
    </section>
    <section name="control3">
      <setting name="action" value="VolumeUp"/>
      <setting name="id" value="0x000C00E9"/>
      <setting name="name" value="volume up"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control4">
      <setting name="action" value="VolumeDown"/>
      <setting name="id" value="0x000C00EA"/>
      <setting name="name" value="volume down"/>
      <setting name="state" value="0"/>
    </section>

    <section name="indicator0">
      <setting name="action" value="OffHook"/>
      <setting name="id" value="0x00080017"/>
      <setting name="name" value="off-hook"/>
      <setting name="value" value="1"/>
    </section>
    <section name="indicator1">
      <setting name="action" value="OnHook"/>
      <setting name="id" value="0x00080017"/>
      <setting name="name" value="on-hook"/>
      <setting name="value" value="0"/>
    </section>
    <section name="indicator2">
      <setting name="action" value="MuteOn"/>
      <setting name="id" value="0x00080009"/>
      <setting name="name" value="mute"/>
      <setting name="value" value="1"/>
    </section>
    <section name="indicator3">
      <setting name="action" value="MuteOff"/>
      <setting name="id" value="0x00080009"/>
      <setting name="name" value="unmute"/>
      <setting name="value" value="0"/>
    </section>
    <section name="indicator4">
      <setting name="action" value="RingOn"/>
      <setting name="id" value="0x00080018"/>
      <setting name="name" value="ring on"/>
      <setting name="value" value="1"/>
    </section>
    <section name="indicator5">
      <setting name="action" value="RingOff"/>
      <setting name="id" value="0x00080018"/>
      <setting name="name" value="ring off"/>
      <setting name="value" value="0"/>
    </section>

    <section name="indicator">
      <setting name="ringtype" value="NoAudio"/>
      <setting name="callwaitingtype" value="Unknown"/>
    </section>
  </domain>
</settings>