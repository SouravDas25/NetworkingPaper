from unittest import TestCase

from main.dp.JumpGame2 import JumpGameII


class TestJumpGameII(TestCase):

    def test_jump(self):
        jg = JumpGameII()
        mj = jg.jump([1, 2, 3])
        print(mj)
