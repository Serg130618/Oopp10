import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


public class RadioChTest {
    Radio radio = new Radio(10);

    @Test
    public void stationEntered() {
        int maxStation = 9;
        int actual = radio.getMaxStation();
        int expected = maxStation;
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/station.csv")

    public void Next(int currentStation, int expected) {
        radio.setCurrentStation(currentStation);
        radio.next();
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/Prev.csv")

    public void Prev(int currentStation, int expected) {
        radio.setCurrentStation(currentStation);
        radio.prev();
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/ivolume.csv")
    public void shouldIncreaseVolume(int currentVolume, int expected) {
        radio.setCurrentVolume(currentVolume);
        radio.increaseVolume();
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/volume.csv")

    public void shouldReductionVolume(int currentVolume, int expected) {
        radio.setCurrentVolume(currentVolume);
        radio.reductionVolume();
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/reduction.csv")
    public void reductionVolume(int currentVolume, int expected) {
        Radio radio = new Radio();
        radio.setCurrentVolume(currentVolume);
        radio.reductionVolume();

        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }


}