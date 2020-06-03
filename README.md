# Android Simulator
This project simulates the interface and simple workings of an android mobile phone.

## Run

- From the `raw-pipeline` branch, run
  1. ```bash
     cd simulator
     ```
  2. ```javac
     javac *.java
     ```
  3. ```javac
     java PanelTest
     ```

- From the `leandeploy` branch, run
  1. ```javac
     javac simulator/phone/*.java
     ```
  2. ```javac
     java -cp . simulator.phone.PanelTest
     ```


## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.


## License
[MIT](https://choosealicense.com/licenses/mit/)
