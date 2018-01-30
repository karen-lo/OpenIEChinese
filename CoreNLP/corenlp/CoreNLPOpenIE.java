// demo code from: https://github.com/stanfordnlp/CoreNLP/blob/master/src/edu/stanford/nlp/naturalli/OpenIEDemo.java
package corenlp;

import edu.stanford.nlp.ie.util.RelationTriple;
import edu.stanford.nlp.simple.*;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.naturalli.NaturalLogicAnnotations;
import edu.stanford.nlp.naturalli.OpenIE;
import edu.stanford.nlp.naturalli.SentenceFragment;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations;
import edu.stanford.nlp.util.CoreMap;
import edu.stanford.nlp.util.PropertiesUtils;

import java.util.Collection;
import java.util.List;
import java.util.Properties;

public class CoreNLPOpenIE {
    public static void main(String[] args) throws Exception {
        // Create the Stanford CoreNLP pipeline
        /*Properties props = PropertiesUtils.asProperties("annotators", "tokenize, ssplit, pos, lemma, depparse, natlog, openie");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        // Annotate an example document.
        String text;
        if (args.length > 0) {
            text = IOUtils.slurpFile(args[0]);
        } else {
            text = "昨天我在家里睡觉。";
            //text = "Obama was born in Hawaii. He is our president.";
        }
        Annotation doc = new Annotation(text);
        pipeline.annotate(doc);

        // Loop over sentences in the document
        int sentNo = 0;
        for (CoreMap sentence : doc.get(CoreAnnotations.SentencesAnnotation.class)) {
            System.out.println("Sentence #" + ++sentNo + ": " + sentence.get(CoreAnnotations.TextAnnotation.class));

            // Print SemanticGraph
            System.out.println(sentence.get(SemanticGraphCoreAnnotations.EnhancedDependenciesAnnotation.class).toString(SemanticGraph.OutputFormat.LIST));

            // Get the OpenIE triples for the sentence
            Collection<RelationTriple> triples = sentence.get(NaturalLogicAnnotations.RelationTriplesAnnotation.class);

            // Print the triples
            for (RelationTriple triple : triples) {
                System.out.println(triple.confidence + "\t" +
                        triple.subjectLemmaGloss() + "\t" +
                        triple.relationLemmaGloss() + "\t" +
                        triple.objectLemmaGloss());
            }

            // Alternately, to only run e.g., the clause splitter:
            List<SentenceFragment> clauses = new OpenIE(props).clausesInSentence(sentence);
            for (SentenceFragment clause : clauses) {
                System.out.println(clause.parseTree.toString(SemanticGraph.OutputFormat.LIST));
            }
            System.out.println();
        }*/

        // Create a CoreNLP document
        Document doc = new Document("昨天我在家里睡觉");

        // Iterate over the sentences in the document
        for (Sentence sent : doc.sentences()) {
            // Iterate over the triples in the sentence
            for (RelationTriple triple : sent.openieTriples()) {
                // Print the triple
                System.out.println(triple.confidence + "\t" +
                        triple.subjectLemmaGloss() + "\t" +
                        triple.relationLemmaGloss() + "\t" +
                        triple.objectLemmaGloss());
            }
        }
    }
}
