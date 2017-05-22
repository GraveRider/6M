import lt.itakademija.*;

public class Organizer implements DocumentOrganizer {

    private DocumentTypeDetector detector;
    private long lineCount;
    private long documentCount;
    private Document document;

    public Organizer(DocumentTypeDetector detector) {
        this.detector = detector;
    }

    @Override
    public long getTotalCount() {
        return this.documentCount;
    }

    @Override
    public long getTotalLinesCount() {
        return this.lineCount;
    }

    @Override
    public void organize(DocumentProducer documentProducer, DocumentConsumer documentConsumer) {
        if (documentProducer == null) {
            throw new IllegalArgumentException();
        } else if (documentConsumer == null) {
            throw new IllegalArgumentException();
        }
        document = documentProducer.get();

        while (document != null) {
            this.documentCount++;
            this.lineCount += document.getLines().size();
            if (detector.detect(document).equals(DocumentType.UNKNOWN)) {
                throw new UnknownDocumentTypeException("Document type not recognised");
            } else {
                if (detector.detect(document).equals(DocumentType.IMPORTANT)) {
                    documentConsumer.consumeImportant(document);
                } else if (detector.detect(document).equals(DocumentType.ORDINARY)) {
                    documentConsumer.consumeOrdinary(document);
                } else {
                    documentConsumer.consumeSpam(document);
                }
                document = documentProducer.get();
            }
        }
    }
}

