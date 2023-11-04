from enum import Enum
from TV import TV

class Range(Enum):
  Wide = "wide"
  Short = "short"

class TVWithTuner(TV):
  def __init__(self, name: str, channel: int, volume: int, rng: Range):
    super().__init__(name, channel, volume)
    self.__range = rng

  def getRange(self) -> Range: return self.__range
  def setRange(self, rng: Range): self.__range = rng
