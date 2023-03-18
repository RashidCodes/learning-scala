package com.oreilly

class RGBColor(val color: Int) { def hex = f"$color%06X"};

trait Opaque extends RGBColor { override def hex = s"${super.hex}FF" };

trait Sheer extends RGBColor { override def hex = s"${super.hex}33" };

class Paint(color: Int) extends RGBColor(color) with Opaque;
class Overlay(color: Int) extends RGBColor(color) with Sheer;