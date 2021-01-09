package connection;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

import java.io.IOException;
import java.util.List;

public class SolrConnectionTest {


    public static void main(String[]args) throws IOException, SolrServerException {
        SolrClient client = new HttpSolrClient.Builder("http://localhost:8983/solr/techproducts").build();
        SolrQuery query = new SolrQuery();

        query.set("q", "name:test");

        QueryResponse queryResponse = client.query(query);

        //why is this needed?
        List<SolrIndex> documents = queryResponse.getBeans(SolrIndex.class);

        SolrDocumentList numberOfDocumnets = queryResponse.getResults();

        System.out.println(documents);
        System.out.println(numberOfDocumnets);

    }
}
