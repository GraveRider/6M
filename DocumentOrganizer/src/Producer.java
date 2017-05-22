import lt.itakademija.Document;
import lt.itakademija.DocumentProducer;

import java.util.Iterator;

public class Producer implements DocumentProducer {

    private Iterator<Document> iterator;

    public Producer(Iterator<Document> iterator) {
        this.iterator = iterator;
    }

    @Override
    public Document get() {
        if(iterator.hasNext() == false) {
            return null;
        }
        else {
            return iterator.next();
        }
    }
}
