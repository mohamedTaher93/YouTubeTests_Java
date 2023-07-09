Feature: Open youtube and play video

  Background:
    Given I navigate to youtube

  Scenario Outline: Search for "<videoTitle>" video on youtube
      When I search for "<videoTitle>" video
      Then Verify the video displayed in the search page

      Examples:
        | videoTitle                |
        | Introduction to Integrant |

  Scenario Outline: Play "<videoTitle>" video on youtube
    When I search for "<videoTitle>" video
    Then Verify the video displayed in the search page
    When I press on the video
    Then Verify the video page opened
    And Verify the video has started playing

    Examples:
      | videoTitle                |
      | Introduction to Integrant |

  Scenario Outline: Pause "<videoTitle>" video on youtube
    When I search for "<videoTitle>" video
    Then Verify the video displayed in the search page
    When I press on the video
    Then Verify the video page opened
    When I pause the video
    Then Verify the video paused successfully

    Examples:
      | videoTitle                |
      | Introduction to Integrant |

  Scenario Outline: Check channel name of "<videoTitle>" displayed on youtube
    When I search for "<videoTitle>" video
    Then Verify the video displayed in the search page
    When I press on the video
    Then Verify the video page opened
    And Verify "<channelName>" displayed

    Examples:
      | videoTitle                | channelName       |
      | Introduction to Integrant | IntegrantSoftware |