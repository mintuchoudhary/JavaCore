public class TRANSACTION_ISOLATION {
    /**
     READ_UNCOMMITTED

     READ_UNCOMMITTED isolation level states that a transaction may read data that is still
     uncommitted by other transactions. This constraint is very relaxed in what matters
     to transactional concurrency but it may lead to some issues like dirty reads.

     READ_COMMITTED

     READ_COMMITTED isolation level states that a transaction can't read data that is
     not yet committed by other transactions. This means that the dirty read is no longer
     an issue, but even this way other issues may occur.

     REPEATABLE_READ

     REPEATABLE_READ isolation level states that if a transaction reads one record
     from the database multiple times the result of all those reading operations must always be the same.
     This eliminates both the dirty read and the non-repeatable read issues, but even this way other
     issues may occur

     SERIALIZABLE

     SERIALIZABLE isolation level is the most restrictive of all isolation levels.
     Transactions are executed with locking at all levels
     */
}
