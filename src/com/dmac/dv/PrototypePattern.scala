package com.dmac.dv

/**
  * Created by dharshekthvel on 10/27/16.
  */
object PrototypePattern {

  def main(args: Array[String]) = {

    def primaryObject = new ContractMeshStateVO("First")

    def clonedObject = primaryObject
  }
}

//implicit def contractMeshStateVOClone(contractMeshStateVO: ContractMeshStateVO) :  ContractMeshStateVOClone = new ContractMeshStateVOClone(contractMeshStateVO)


class ContractMeshStateVOClone(contractMeshStateVO: ContractMeshStateVO) {
  def copy = new ContractMeshStateVO(contractMeshStateVO.state)
}

class ContractMeshStateVO(var state: String)