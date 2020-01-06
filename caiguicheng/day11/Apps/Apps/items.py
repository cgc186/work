# -*- coding: utf-8 -*-

# Define here the models for your scraped items
#
# See documentation in:
# https://docs.scrapy.org/en/latest/topics/items.html

import scrapy


class AppsItem(scrapy.Item):
    title = scrapy.Field()  # 名字
    volume = scrapy.Field()  # 文件大小
    downloads = scrapy.Field()  # 下载量
    follow = scrapy.Field()  # 关注量
    comment = scrapy.Field()  # 评论数
    tags = scrapy.Field()  # 标签
    rank_num = scrapy.Field()  # 分数
    rom = scrapy.Field()  # 版本
    developer = scrapy.Field()  # 开发者
    rank_num_users = scrapy.Field()  # 评分人数
    update_time = scrapy.Field()  # 更新时间

