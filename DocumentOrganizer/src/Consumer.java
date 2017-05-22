import lt.itakademija.Document;
import lt.itakademija.DocumentConsumer;
import lt.itakademija.FileRepository;

public class Consumer implements DocumentConsumer {

   private FileRepository repository;

   public Consumer(FileRepository repository) {
       this.repository = repository;
   }

    @Override
    public void consumeSpam(Document document) {
        repository.putSpam(document);
    }

    @Override
    public void consumeImportant(Document document) {
        repository.putImportant(document);
    }

    @Override
    public void consumeOrdinary(Document document) {
        repository.putOrdinary(document);
    }
}
