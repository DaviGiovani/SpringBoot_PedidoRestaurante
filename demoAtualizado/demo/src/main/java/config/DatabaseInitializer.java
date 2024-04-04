package config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import com.example.demo.repository.PedidoRepository;

@Component
public class DatabaseInitializer implements ApplicationRunner {

    private PedidoRepository pedidoRepository;

    @Autowired
    public DatabaseInitializer(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        pedidoRepository.deleteAll();
    }
}
