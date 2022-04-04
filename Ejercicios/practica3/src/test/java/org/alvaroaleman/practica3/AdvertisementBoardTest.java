package org.alvaroaleman.practica3;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;


class AdvertisementBoardTest {



  @Test
  public void ABoardHasAnAdvertisementWhenItIsCreated() {

    AdvertisementBoard board = Mockito.mock(AdvertisementBoard.class);

    //Execute
    Mockito.when(board.numberOfPublishedAdvertisements()).thenReturn(1);

  }

  @Test
  public void PublishAnAdvertisementByTheCompanyIncreasesTheNumberOfAdvertisementsByOne() {

    AdvertisementBoard board = Mockito.mock(AdvertisementBoard.class);
    PaymentDatabase pdb = Mockito.mock(PaymentDatabase.class);
    AdvertiserDatabase adb = Mockito.mock(AdvertiserDatabase.class);


    Advertisement anuncio = new Advertisement("titulo", "texto", "THE Company");

    board.publish(anuncio,adb,pdb);

    Mockito.when(board.numberOfPublishedAdvertisements()).thenReturn(2);


  }

  @Test
  public void WhenAnAdvertiserHasNoFoundsTheAdvertisementIsNotPublished() {

    AdvertisementBoard board = new AdvertisementBoard();
    AdvertiserDatabase adb = Mockito.mock(AdvertiserDatabase.class);
    PaymentDatabase pdb = Mockito.mock(PaymentDatabase.class);
    Advertisement ad = new Advertisement("titulo","texto","Pepe Gotera y Otilio");

    Mockito.when(adb.findAdviser("Pepe Gotera y Otilio" )).thenReturn(true);
    Mockito.when(pdb.advertiserHasFunds("Pepe Gotera y Otilio" )).thenReturn(false);

    int actualValue = board.numberOfPublishedAdvertisements();
    board.publish(ad ,adb ,pdb );
    int expectedValue = 1;

    assertEquals(expectedValue, actualValue);


  }

  @Test
  public void AnAdvertisementIsPublishedIfTheAdvertiserIsRegisteredAndHasFunds() {

    AdvertisementBoard board = new AdvertisementBoard();
    AdvertiserDatabase adb = Mockito.mock(AdvertiserDatabase.class);
    PaymentDatabase pdb = Mockito.mock(PaymentDatabase.class);
    Advertisement ad = new Advertisement("titulo","texto","Robin Robot");

    Mockito.when(adb.findAdviser("Robin Robot")).thenReturn(true);
    Mockito.when(pdb.advertiserHasFunds("Robin Robot")).thenReturn(true);

    int actualValue = board.numberOfPublishedAdvertisements();
    board.publish(ad ,adb ,pdb );
    int expectedValue = 1;

    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void WhenTheOwnerMakesTwoPublicationsAndTheFirstOneIsDeletedItIsNotInTheBoard() {
    AdvertisementBoard board = new AdvertisementBoard();
    AdvertiserDatabase adb = Mockito.mock(AdvertiserDatabase.class);
    PaymentDatabase pdb = Mockito.mock(PaymentDatabase.class);
    Advertisement ad = new Advertisement("titulo","texto","Advertiser");
    Advertisement ad2 = new Advertisement("titulo1","texto1","Advertiser");

    board.publish(ad ,adb ,pdb );
    board.publish(ad2 ,adb ,pdb );
    board.deleteAdvertisement("titulo1", "Advertiser");

    Advertisement actualValue = board.findByTitle("titulo1");
    Advertisement expectedValue = null;

    assertEquals(expectedValue, actualValue);

  }

  @Test
  public void AnExistingAdvertisementIsNotPublished() {}

  @Test
  public void AnExceptionIsRaisedIfTheBoardIsFullAndANewAdvertisementIsPublished() {}
}