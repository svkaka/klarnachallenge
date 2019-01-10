### todo
- use Address API to present city and street to user
- use some kind of pool for presenters so I don't have static field inside activity
- handle error messages better
- getWeather isCalled twice in onCreate (bad decision, I could have at least some boolean back if it was called)
- remove possibility to create multiple async requests for fetching weather
- exclude some fields from response eg: (https://api.dar ... 81?exclude=hourly,daily,flags)
- format it a bit and remove empty lines, more readable variable names, some documentation
- Add progress bar
- nicer UI
- forgot to clear activity in onStop

### parrallel codeverse
... where I can use other dependencies and had more time
- I would modularize project at least by creating separate module for entities, and remote (/usecase)
- use databinding for ONLY populating UI with response
- use coroutines / RX-java for non-blocking
- use retrofit to handle fetching from remotes
- add some tests to verify base functionality
- use gson/moshi for parsing json
- use fragments for UI and single activity
- use Architecture components ViewModel for storing data, LiveData for observing data
- make use of lifecycle owner for locationProvider
