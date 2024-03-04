package com.mongodb.spark.sql.connector.schema;

import org.apache.spark.sql.catalyst.expressions.AttributeReference;
import org.apache.spark.sql.catalyst.expressions.ExprId;
import org.apache.spark.sql.catalyst.expressions.ExprId$;
import org.apache.spark.sql.catalyst.expressions.NamedExpression;
import org.apache.spark.sql.types.StructField;
import scala.collection.JavaConverters;

import java.util.Collections;
import java.util.function.Function;

/**
 * Created by Alban on 04 Mar, 2024
 */
class StructFieldToAttributeFunction implements Function<StructField, AttributeReference> {
    @Override
    public AttributeReference apply(final StructField field) {
        ExprId exprId = NamedExpression.newExprId();
        return new AttributeReference(
                field.name(),
                field.dataType(),
                field.nullable(),
                field.metadata(),
                ExprId$.MODULE$.apply(exprId.id()),
                JavaConverters.asScalaBuffer(Collections.emptyList()));
    }
}
