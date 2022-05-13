package algebra

object AbstractAlgebraFinite {
  // TASK: search the set s for an identity element,
  //    return None if no such element exists
  //    otherwise return that element wrapped in Some(...)
  def findIdentity[T](s: Set[T], op: (T, T) => T): Option[T] = {
    // The identity is guaranteed to be unique if it exists.
    // Because if there are two identifies e1 and e2, then
    // op(e1,e2)=e1 and op(e1,e2)=e2, by definition of identity.
    // so e1=e2.
    ???
  }

  // TASK: Given a set and binary operation, detect exhaustively
  //   whether it is a monoid.  I.e., check all possible cases
  //   of the monoid axioms.
  def isMonoid[T](s: Set[T], op: (T, T) => T): Boolean = {
    // has identity ?
    // is closed ?
    // is associative ?
    ???
  }

  // TASK: Given a set and binary operation, detect exhaustively
  //   whether it is a group.  I.e., check all possible cases
  //   of the group axioms.   Make use of the isMonoid function.
  def isGroup[T](s: Set[T], op: (T, T) => T): Boolean = {
    // is monoid?
    // every element has identity
    ???
  }

  // TASK: Given a set and binary operation, detect exhaustively
  //   whether the operation is commutative
  def isAbelian[T](s: Set[T], op: (T, T) => T): Boolean = {
    ???
  }

  // TASK: Given a set and binary operation, detect exhaustively
  //   whether it is a ring.  I.e., check all possible cases
  //   of the ring axioms.  make use of the isGroup, isAbelian, and isMonoid
  //   functions.
  def isRing[T](s: Set[T], add: (T, T) => T, times: (T, T) => T): Boolean = {
    // does addition make an Abelian group
    // does times make a monoid
    // does distributive law work for ALL elements
    ???
  }

  // TASK: Given a set and binary operation, detect exhaustively
  //   whether it is a field.  I.e., check all possible cases
  //   of the field axioms.  make use of the isRing, isAbelian, and isGroup
  //   functions.   Be careful, the set is not necessarily a group,
  //   you must test group-ness on the set minus the zero element, which
  //   you must find using the findIdentity function.
  def isField[T](s: Set[T], add: (T, T) => T, times: (T, T) => T): Boolean = {
    // is times commutative
    // is it a ring
    // is times a ring if we remove the additive zero?
    ???
  }
}
