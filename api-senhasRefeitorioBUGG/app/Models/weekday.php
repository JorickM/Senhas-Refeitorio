<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class weekday extends Model
{
    use HasFactory;
    protected $table = 'weekdays';
    protected $fillable = ['name', 'date'];
}
