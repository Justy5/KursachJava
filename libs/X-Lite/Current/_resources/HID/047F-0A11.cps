<?xml version="1.0" encoding="UTF-8" ?>
<settings version="1.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://www.counterpath.com/cps">
  <domain name="hid">

<!-- Plantronics P540-M -->

<!-- the hook switch fires up/dn on off-hook -->
    <section name="control0">
      <setting name="action" value="0"/>
      <setting name="id" value="0x000B0020"/>
      <setting name="name" value="off hook"/>
      <setting name="state" value="1"/>
    </section>
    <section name="control1">
      <setting name="action" value="4"/>
      <setting name="id" value="0x000B0021"/>
      <setting name="name" value="hold"/>
      <setting name="state" value="1"/>
    </section>
<!-- DRL It seems this button only fires during a call?? -->
    <section name="control2">
      <setting name="action" value="4"/>
      <setting name="id" value="0x000B0024"/>
      <setting name="name" value="redial"/>
      <setting name="state" value="1"/>
    </section>
<!-- DRL Since we don't have on-hook we'll use the reject key for this -->
    <section name="control3">
      <setting name="action" value="1"/>
      <setting name="id" value="0x00090007"/>
      <setting name="name" value="reject (X key)"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control4">
      <setting name="action" value="8"/>
      <setting name="id" value="0x000B00B0"/>
      <setting name="name" value="key 0"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control5">
      <setting name="action" value="9"/>
      <setting name="id" value="0x000B00B1"/>
      <setting name="name" value="key 1"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control6">
      <setting name="action" value="10"/>
      <setting name="id" value="0x000B00B2"/>
      <setting name="name" value="key 2"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control7">
      <setting name="action" value="11"/>
      <setting name="id" value="0x000B00B3"/>
      <setting name="name" value="key 3"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control8">
      <setting name="action" value="12"/>
      <setting name="id" value="0x000B00B4"/>
      <setting name="name" value="key 4"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control9">
      <setting name="action" value="13"/>
      <setting name="id" value="0x000B00B5"/>
      <setting name="name" value="key 5"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control10">
      <setting name="action" value="14"/>
      <setting name="id" value="0x000B00B6"/>
      <setting name="name" value="key 6"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control11">
      <setting name="action" value="15"/>
      <setting name="id" value="0x000B00B7"/>
      <setting name="name" value="key 7"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control12">
      <setting name="action" value="16"/>
      <setting name="id" value="0x000B00B8"/>
      <setting name="name" value="key 8"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control13">
      <setting name="action" value="17"/>
      <setting name="id" value="0x000B00B9"/>
      <setting name="name" value="key 9"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control14">
      <setting name="action" value="18"/>
      <setting name="id" value="0x000B00BA"/>
      <setting name="name" value="key *"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control15">
      <setting name="action" value="19"/>
      <setting name="id" value="0x000B00BB"/>
      <setting name="name" value="key #"/>
      <setting name="state" value="0"/>
    </section>
    <section name="control16">
      <setting name="action" value="5"/>
      <setting name="id" value="0x000B002F"/>
      <setting name="name" value="mute toggle"/>
      <setting name="state" value="0"/>
    </section>

    <section name="controlinfo0">
      <setting name="id" value="0xFF990060"/>
      <setting name="name" value="unknown"/>
      <setting name="usagetype" value="2"/>
    </section>
    <section name="controlinfo1">
      <setting name="id" value="0xFF990061"/>
      <setting name="name" value="unknown"/>
      <setting name="usagetype" value="2"/>
    </section>

    <section name="control">
      <setting name="playsdtmf" value="0"/>
    </section>

    <section name="indicator0">
      <setting name="action" value="5"/>
      <setting name="id" value="0x00080017"/>
      <setting name="name" value="on-hook"/>
      <setting name="value" value="0"/>
    </section>
    <section name="indicator1">
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