package mtas.solr.schema;

import java.io.IOException;
import java.util.Map;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.Analyzer.TokenStreamComponents;
import org.apache.lucene.index.IndexableField;
import org.apache.solr.schema.IndexSchema;
import org.apache.solr.schema.JsonPreAnalyzedParser;
import org.apache.solr.schema.PreAnalyzedField;
import org.apache.solr.schema.SchemaField;

/**
 * The Class MtasPreAnalyzedField.
 */
public class MtasPreAnalyzedField extends PreAnalyzedField {

  /** The follow index analyzer. */
  private final static String FOLLOW_INDEX_ANALYZER = "followIndexAnalyzer";

  /** The default configuration. */
  private final static String DEFAULT_CONFIGURATION = "defaultConfiguration";

  /** The configuration from field. */
  private final static String CONFIGURATION_FROM_FIELD = "configurationFromField";

  /** The set number of tokens. */
  private final static String SET_NUMBER_OF_TOKENS = "setNumberOfTokens";

  /** The set number of positions. */
  private final static String SET_NUMBER_OF_POSITIONS = "setNumberOfPositions";

  /** The set size. */
  private final static String SET_SIZE = "setSize";

  /** The set error. */
  private final static String SET_ERROR = "setError";

  /** The set prefix. */
  private final static String SET_PREFIX = "setPrefix";

  /** The follow index analyzer. */
  public String followIndexAnalyzer = null;

  /** The default configuration. */
  public String defaultConfiguration = null;

  /** The configuration from field. */
  public String configurationFromField = null;

  /** The set number of tokens. */
  public String setNumberOfTokens = null;

  /** The set number of positions. */
  public String setNumberOfPositions = null;

  /** The set size. */
  public String setSize = null;

  /** The set error. */
  public String setError = null;

  /** The set prefix. */
  public String setPrefix = null;

  /*
   * (non-Javadoc)
   * 
   * @see org.apache.solr.schema.PreAnalyzedField#init(org.apache.solr.schema.
   * IndexSchema, java.util.Map)
   */
  @Override
  public void init(IndexSchema schema, Map<String, String> args) {
    args.put(PARSER_IMPL, MtasPreAnalyzedParser.class.getName());
    super.init(schema, args);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.apache.solr.schema.FieldType#setArgs(org.apache.solr.schema.
   * IndexSchema, java.util.Map)
   */
  @Override
  protected void setArgs(IndexSchema schema, Map<String, String> args) {
    followIndexAnalyzer = args.get(FOLLOW_INDEX_ANALYZER);
    defaultConfiguration = args.get(DEFAULT_CONFIGURATION);
    configurationFromField = args.get(CONFIGURATION_FROM_FIELD);
    setNumberOfTokens = args.get(SET_NUMBER_OF_TOKENS);
    setNumberOfPositions = args.get(SET_NUMBER_OF_POSITIONS);
    setSize = args.get(SET_SIZE);
    setError = args.get(SET_ERROR);
    setPrefix = args.get(SET_PREFIX);
    if (followIndexAnalyzer == null) {
      throw new RuntimeException("No " + FOLLOW_INDEX_ANALYZER
          + " for fieldType " + this.getTypeName());
    }
    args.remove(FOLLOW_INDEX_ANALYZER);
    args.remove(DEFAULT_CONFIGURATION);
    args.remove(CONFIGURATION_FROM_FIELD);
    args.remove(SET_NUMBER_OF_TOKENS);
    args.remove(SET_NUMBER_OF_POSITIONS);
    args.remove(SET_SIZE);
    args.remove(SET_ERROR);
    args.remove(SET_PREFIX);
    super.setArgs(schema, args);
  }

}