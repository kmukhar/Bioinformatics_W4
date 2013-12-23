package com.mukhar;

public class Node {
  private int id;

  public Node(String node) {
    this.id = Integer.valueOf(node.trim());
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    return result;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Node other = (Node) obj;
    if (id != other.id) {
      return false;
    }
    return true;
  }

  public int getId()
  {
    return id;
  }
}
