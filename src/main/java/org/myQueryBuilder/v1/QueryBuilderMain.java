package org.myQueryBuilder.v1;



public class QueryBuilderMain {
    public static void main(String[] args) {
        String simpleQuery = new QueryBuilder()
                .select("name", "age")
                .from("users")
                .where("age > 30")
                .orderBy("name")
                .build();

        System.out.println("\nSimple Query:\n" + simpleQuery);

        String complexQuery = new QueryBuilder()
                .select("users.name", "COUNT(orders.order_id) as order_count")
                .from("users")
                .join(JoinType.LEFT, "orders", "users.user_id = orders.user_id")
                .where("users.age > 25 AND orders.status = 'Shipped'")
                .groupBy("users.name")
                .orderBy("order_count DESC")
                .build();
        System.out.println("\nComplex Query:\n" + complexQuery);
    }

}
