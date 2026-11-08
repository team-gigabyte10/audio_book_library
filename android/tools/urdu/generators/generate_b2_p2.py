"""Generates Level B2 Part 2 (Units ur-b2-09 to ur-b2-16) for Urdu Spoken Course."""
import os
import sys

script_dir = os.path.dirname(os.path.abspath(__file__))
if script_dir not in sys.path:
    sys.path.insert(0, script_dir)

from data_b2_u09_u12 import raw_parts as p2_u09_u12
from data_b2_u13_u16 import raw_parts as p2_u13_u16

parts_p2 = p2_u09_u12 + p2_u13_u16
