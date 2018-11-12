package com.common;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DateUtils {

	public static final LocalDateTime  nowLocalDateTime = LocalDateTime.now();
	
	public static final Timestamp  nowTimestamp = Timestamp.valueOf(nowLocalDateTime);
}
