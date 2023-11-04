class TV:
  def __init__(self, name: str, channel: int, volume: int):
    self.__name = name
    self.__channel = channel
    self.__volume = volume

  def getName(self) -> str: return self.__name
  def setName(self, name): self.__name = name
  
  def getChannel(self) -> int: return self.__channel
  def setChannel(self, channel): self.__channel = channel

  def getVolume(self) -> int: return self.__volume
  def setVolume(self, volume): self.__volume = volume
