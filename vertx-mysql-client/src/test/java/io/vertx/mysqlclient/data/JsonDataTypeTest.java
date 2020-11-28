package io.vertx.mysqlclient.data;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.unit.TestContext;
import io.vertx.sqlclient.Row;
import io.vertx.sqlclient.Tuple;
import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.function.Consumer;

public abstract class JsonDataTypeTest extends MySQLDataTypeTestBase {
  @BeforeClass
  public static void beforeAll() {
    // JSON data type is introduced in MySQL 5.7
    Assume.assumeFalse(rule.isUsingMySQL5_6());
    // MariaDB JSON data type is different
    Assume.assumeFalse(rule.isUsingMariaDB());
  }

  @Test
  public void testDecodeString(TestContext ctx) {
    testDecodeJsonWithCast(ctx, "\'\"test_json_string\"\'", "test_json_string", row -> {
      ctx.assertEquals("test_json_string", row.getString(0));
      ctx.assertEquals("test_json_string", row.getString("json"));
    });
  }

  @Test
  public void testDecodeStringNull(TestContext ctx) {
    testDecodeJsonWithCast(ctx, "\'\"null\"\'", "null", row -> {
      ctx.assertEquals("null", row.getString(0));
      ctx.assertEquals("null", row.getString("json"));
    });
  }

  @Test
  public void testDecodeJsonLiteralNull(TestContext ctx) {
    testDecodeJsonWithCast(ctx, "\'null\'", Tuple.JSON_NULL, null);
  }

  @Test
  public void testDecodeSqlNull(TestContext ctx) {
    testDecodeJsonWithCast(ctx, "NULL", null, null);
  }

  @Test
  public void testDecodeNumber(TestContext ctx) {
    testDecodeJsonWithCast(ctx, "12345", 12345, row -> {
      ctx.assertEquals(12345, row.getInteger(0));
      ctx.assertEquals(12345, row.getInteger("json"));
    });
  }

  @Test
  public void testDecodeBoolean(TestContext ctx) {
    testDecodeJsonWithCast(ctx, "true", true, row -> {
      ctx.assertEquals(true, row.getBoolean(0));
      ctx.assertEquals(true, row.getBoolean("json"));
    });
  }

  @Test
  public void testDecodeJsonObject(TestContext ctx) {
    String script = "SELECT JSON_OBJECT(\n" +
      "               'test_string', 'hello',\n" +
      "               'test_number', 12345,\n" +
      "               'test_boolean', true,\n" +
      "               'test_null', null,\n" +
      "               'test_json_object', JSON_OBJECT('key', 'value'),\n" +
      "               'test_json_array', JSON_ARRAY(1, 2, 3)\n" +
      "           ) json;";

    JsonObject expected = new JsonObject()
      .put("test_string", "hello")
      .put("test_number", 12345)
      .put("test_boolean", true)
      .put("test_null", (Object) null)
      .put("test_json_object", new JsonObject().put("key", "value"))
      .put("test_json_array", new JsonArray().add(1).add(2).add(3));
    testDecodeJson(ctx, script, expected, row -> ctx.assertEquals(expected, row.get(JsonObject.class, 0)));
  }

  @Test
  public void testDecodeJsonArray(TestContext ctx) {
    String script = "SELECT JSON_ARRAY(\n" +
      "               'hello', 12345, true, null, JSON_OBJECT('key', 'value'), JSON_ARRAY(1, 2, 3)\n" +
      "           ) json;";

    JsonArray expected = new JsonArray()
      .add("hello")
      .add(12345)
      .add(true)
      .add((Object) null)
      .add(new JsonObject().put("key", "value"))
      .add(new JsonArray().add(1).add(2).add(3));
    testDecodeJson(ctx, script, expected, row -> ctx.assertEquals(expected, row.get(JsonArray.class, 0)));
  }

  private void testDecodeJsonWithCast(TestContext ctx, String data, Object expected, Consumer<Row> checker) {
    testDecodeJson(ctx, "SELECT CAST(" + data + " AS JSON) json;", expected, checker);
  }

  protected void assertJsonStringEquals(TestContext ctx, Object expected, String actual) {
    if (expected instanceof JsonObject) {
      // the JsonObject fields may be reordered
      ctx.assertEquals(expected, new JsonObject(actual));
    } else {
      ctx.assertEquals(retrieveJsonAsString(expected), actual);
    }
  }

  private String retrieveJsonAsString(Object obj) {
    if (obj == null || obj == Tuple.JSON_NULL) {
      return null;
    } else if (obj instanceof Number || obj instanceof Boolean) {
      return obj.toString();
    } else if (obj instanceof JsonObject) {
      return ((JsonObject) obj).encode();
    } else if (obj instanceof JsonArray) {
      return ((JsonArray) obj).encode();
    } else if (obj instanceof String) {
      return (String) obj;
    }
    throw new IllegalStateException("Unknown JSON Type");
  }

  protected abstract void testDecodeJson(TestContext ctx, String script, Object expected, Consumer<Row> checker);
}
