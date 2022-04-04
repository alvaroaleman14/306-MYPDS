package org.alvaroaleman.practica3;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;


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

    AdvertisementBoard board = Mockito.mock(AdvertisementBoard.class);
    AdvertiserDatabase adb = Mockito.mock(AdvertiserDatabase.class);
    PaymentDatabase pdb = Mockito.mock(PaymentDatabase.class);

    Advertisement anuncio = new Advertisement("titulo", "texto", "Advertiser");

    Mockito.when(pdb.advertiserHasFunds("Advertiser")).thenReturn(false);

    Mockito.verify(board).publish(anuncio,adb,pdb);
  }

  @Test
  public void AnAdvertisementIsPublishedIfTheAdvertiserIsRegisteredAndHasFunds() {}

  @Test
  public void WhenTheOwnerMakesTwoPublicationsAndTheFirstOneIsDeletedItIsNotInTheBoard() {}

  @Test
  public void AnExistingAdvertisementIsNotPublished() {}

  @Test
  public void AnExceptionIsRaisedIfTheBoardIsFullAndANewAdvertisementIsPublished() {}
}