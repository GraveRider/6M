

import lt.itakademija.*;

import java.util.Iterator;

public class DocumentTest extends BaseTest {

    @Override
    protected DocumentOrganizer createDocumentOrganizer(DocumentTypeDetector documentTypeDetector) {
        return new Organizer(documentTypeDetector);
    }

    @Override
    protected DocumentProducer createDocumentProducer(Iterator<Document> iterator) {
        return new Producer(iterator);
    }

    @Override
    protected DocumentConsumer createDocumentConsumer(FileRepository fileRepository) {
        return new Consumer(fileRepository);
    }
}