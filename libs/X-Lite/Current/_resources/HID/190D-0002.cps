<?xml version="1.0" encoding="UTF-8" ?>
<settings version="1.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://www.counterpath.com/cps">

<!-- USB SLIC Dongle / USB ITA Audio for Skype -->

  <domain name="hid">

    <section name="control0">
      <setting name="action" value="1"/>
      <setting name="id" value="0x000B0020"/>
      <setting name="name" value="on hook"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control10">
      <setting name="action" value="15"/>
      <setting name="id" value="0x000B00B7"/>
      <setting name="name" value="7"/>
      <setting name="state" value="1"/>
    </section>
    <section name="control11">
      <setting name="action" value="16"/>
      <setting name="id" value="0x000B00B8"/>
      <setting name="name" value="8"/>
      <setting name="state" value="1"/>
    </section>
    <section name="control12">
      <setting name="action" value="17"/>
      <setting name="id" value="0x000B00B9"/>
      <setting name="name" value="9"/>
      <setting name="state" value="1"/>
    </section>
    <section name="control13">
      <setting name="action" value="18"/>
      <setting name="id" value="0x000B00BA"/>
      <setting name="name" value="*"/>
      <setting name="state" value="1"/>
    </section>
    <section name="control14">
      <setting name="action" value="19"/>
      <setting name="id" value="0x000B00BB"/>
      <setting name="name" value="#"/>
      <setting name="state" value="1"/>
    </section>
    <section name="control1">
      <setting name="action" value="0"/>
      <setting name="id" value="0x000B0020"/>
      <setting name="name" value="off hook"/>
      <setting name="state" value="1"/>
    </section>
    <section name="control2">
      <setting name="action" value="4"/>	<!-- hold/resume -->
      <setting name="id" value="0x000B0021"/>
      <setting name="name" value="flash"/>
      <setting name="state" value="1"/>
    </section>
    <section name="control3">
      <setting name="action" value="8"/>
      <setting name="id" value="0x000B00B0"/>
      <setting name="name" value="0"/>
      <setting name="state" value="1"/>
    </section>
    <section name="control4">
      <setting name="action" value="9"/>
      <setting name="id" value="0x000B00B1"/>
      <setting name="name" value="1"/>
      <setting name="state" value="1"/>
    </section>
    <section name="control5">
      <setting name="action" value="10"/>
      <setting name="id" value="0x000B00B2"/>
      <setting name="name" value="2"/>
      <setting name="state" value="1"/>
    </section>
    <section name="control6">
      <setting name="action" value="11"/>
      <setting name="id" value="0x000B00B3"/>
      <setting name="name" value="3"/>
      <setting name="state" value="1"/>
    </section>
    <section name="control7">
      <setting name="action" value="12"/>
      <setting name="id" value="0x000B00B4"/>
      <setting name="name" value="4"/>
      <setting name="state" value="1"/>
    </section>
    <section name="control8">
      <setting name="action" value="13"/>
      <setting name="id" value="0x000B00B5"/>
      <setting name="name" value="5"/>
      <setting name="state" value="1"/>
    </section>
    <section name="control9">
      <setting name="action" value="14"/>
      <setting name="id" value="0x000B00B6"/>
      <setting name="name" value="6"/>
      <setting name="state" value="1"/>
    </section>

    <section name="controlinfo0">
      <setting name="id" value="0x000B0020"/>
      <setting name="name" value="hook switch"/>
      <setting name="usagetype" value="2"/>
    </section>
    <section name="controlinfo1">
      <setting name="id" value="0xFF000051"/>
      <setting name="name" value="device ready"/>
      <setting name="usagetype" value="1"/>
    </section>

    <section name="control">
      <setting name="playsdtmf" value="1"/>
    </section>

    <section name="indicator0">
      <setting name="action" value="1"/>
      <setting name="id" value="0x000B009E"/>
      <setting name="name" value="RingOn"/>
      <setting name="value" value="0x9E"/>
    </section>
    <section name="indicator1">
      <setting name="action" value="2"/>
      <setting name="id" value="0x000B009E"/>
      <setting name="name" value="RingOff"/>
      <setting name="value" value="0"/>
    </section>

    <section name="indicator">
      <setting name="ringtype" value="2"/>	<!-- continuous ringing -->
    </section>
  </domain>
</settings>