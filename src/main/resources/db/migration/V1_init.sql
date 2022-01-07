CREATE TABLE IF NOT EXISTS User (
  UserID INT NOT NULL AUTO_INCREMENT,
  userName VARCHAR(45) NULL,
  password VARCHAR(45) NULL,
  email VARCHAR(45) NULL,
  subscriberCount INT NULL,
  createDate DATE NULL,
  PRIMARY KEY (UserID))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS Message (
    MessageID INT NOT NULL AUTO_INCREMENT,
    content VARCHAR(45) NULL,
    likesCount INT NULL,
    retweetCount INT NULL,
    createDate DATE NULL,
    User_UserID INT NOT NULL,
    PRIMARY KEY (MessageID),
    INDEX fk_Message_User_idx (User_UserID ASC) VISIBLE,
    CONSTRAINT fk_Message_User
    FOREIGN KEY (User_UserID)
    REFERENCES twitterdb.User (UserID)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS Subscription (
    subscriptionID INT NOT NULL AUTO_INCREMENT,
    dateSubscribed DATE NULL,
    userID INT NOT NULL,
    followerID INT NOT NULL,
    PRIMARY KEY (subscriptionID),
    INDEX fk_Subscription_User1_idx (userID ASC) VISIBLE,
    INDEX fk_Subscription_User2_idx (followerID ASC) VISIBLE,
    CONSTRAINT fk_Subscription_User1
    FOREIGN KEY (userID)
    REFERENCES twitterdb.User (UserID)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT fk_Subscription_User2
    FOREIGN KEY (followerID)
    REFERENCES twitterdb.User (UserID)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- insert statement for User table

INSERT INTO User (UserName, password, email, subscriberCount, createDate) VALUES ('Luffy', 'ABCDEF', 'luffy@onepiece.com', '981', '1999-10-20');
INSERT INTO User (UserName, password, email, subscriberCount, createDate) VALUES ('Naruto', 'XYZe', 'naruto@shipuden.gov', '500', '2007-02-15');
INSERT INTO User (UserName, password, email, subscriberCount, createDate) VALUES ('Ichigo', 'LKJH', 'Ichigo@bleach.com	', '366', '2004-10-05');

-- insert statement for Messages

INSERT INTO Message (content, likesCount, retweetCount, createDate, User_UserID) VALUES ('Message one', '13', '21', '2009-10-20', '1');
INSERT INTO Message (content, likesCount, retweetCount, createDate, User_UserID) VALUES ('Message Two', '1', '111', '2002-02-15', '2');
INSERT INTO Message (content, likesCount, retweetCount, createDate, User_UserID) VALUES ('Message Three)', '25', '41', '2007-01-25', '3');
INSERT INTO Message (content, likesCount, retweetCount, createDate, User_UserID) VALUES ('Message Four', '512', '153', '2017-05-05', '2');
INSERT INTO Message (content, likesCount, retweetCount, createDate, User_UserID) VALUES ('Message Five', '5123', '1453', '2020-07-10', '1');

-- insert statement for subscribers

INSERT INTO Subscription (dateSubscribed, UserID, followerID) VALUES ( '2003-11-12','1', '2');
INSERT INTO Subscription (dateSubscribed, UserID, followerID) VALUES ( '2002-12-22','3', '1');
INSERT INTO Subscription (dateSubscribed, UserID, followerID) VALUES ( '2001-01-10','2', '3');