package mtas.solr.search;

import java.io.IOException;

import org.apache.solr.common.params.SolrParams;
import org.apache.solr.common.util.NamedList;
import org.apache.solr.core.CoreContainer;
import org.apache.solr.core.PluginBag.PluginHolder;
import org.apache.solr.handler.component.SearchComponent;
import org.apache.solr.request.SolrQueryRequest;
import org.apache.solr.search.QParser;
import org.apache.solr.search.QParserPlugin;

import mtas.solr.handler.component.MtasSolrSearchComponent;

/**
 * The Class MtasSolrJoinQParserPlugin.
 */
public class MtasSolrJoinQParserPlugin extends QParserPlugin {

  /*
   * (non-Javadoc)
   * 
   * @see org.apache.solr.search.QParserPlugin#init(org.apache.solr.common.util.
   * NamedList)
   */
  @SuppressWarnings("rawtypes")
  @Override
  public void init(NamedList args) {
    // don't do anything
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.apache.solr.search.QParserPlugin#createParser(java.lang.String,
   * org.apache.solr.common.params.SolrParams,
   * org.apache.solr.common.params.SolrParams,
   * org.apache.solr.request.SolrQueryRequest)
   */
  @Override
  public QParser createParser(String qstr, SolrParams localParams,
      SolrParams params, SolrQueryRequest req) {
    return new MtasJoinQParser(qstr, localParams, params, req);
  }

}
