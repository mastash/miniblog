package pl.sda.spiring.miniblog12;

import org.springframework.stereotype.Component;

@Component
public class TemperatureMessageProvider implements MessageProvider{

    @Override
    public String getMessage() {
        return "22";
    }
}
